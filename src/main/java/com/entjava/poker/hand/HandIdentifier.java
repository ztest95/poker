package com.entjava.poker.hand;

import com.entjava.poker.hand.types.*;
import com.entjava.poker.card.Card;
import com.entjava.poker.card.CardRank;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * A service that is to used to identify the {@link Hand} given the player's cards and the community
 * cards.
 */
@Component
public class HandIdentifier {

    /**
     * Given the player's cards and the community cards, identifies the player's hand.
     *
     * @param playerCards
     * @param communityCards
     * @return The player's {@link Hand} or `null` if no Hand was identified.
     */
    public Hand identifyHand(List<Card> playerCards, List<Card> communityCards) {

        if(communityCards.isEmpty()) {
            if(playerCards.stream().allMatch((Card card) -> card.getRank() == playerCards.get(0).getRank())) {
                return new OnePair(playerCards, new ArrayList<>());
            } else {
                return new HighCard(playerCards);
            }
        }

        List<Card> combinedCards = new ArrayList<>();
        combinedCards.addAll(playerCards);
        combinedCards.addAll(communityCards);

        Collections.sort(combinedCards,Collections.reverseOrder());

        HashMap<String,List<Card>> sameCardSuitMap = new HashMap<>();
        for (Card c : combinedCards) {
            if(sameCardSuitMap.containsKey(c.getSuit().toString())) {
                sameCardSuitMap.get(c.getSuit().toString()).add(c);
            } else {
                List<Card> tempCardsList = new ArrayList<>();
                tempCardsList.add(c);
                sameCardSuitMap.put(c.getSuit().toString(),tempCardsList);
            }
        }

        // check for five card hands
        // check for cards with same suits of 5
        List<Card> sameSuitCardsList = sameCardSuitMap.values().stream().filter(l -> l.size()>=5).findFirst().orElse(new ArrayList<>());

        if(sameSuitCardsList.size()!=0) {

            boolean isStraight = false;

            if(sameSuitCardsList.get(0).getRank() == CardRank.ACE) {
                sameSuitCardsList.add(sameSuitCardsList.get(0));
            }
            for(int ctr = 0; ctr < (sameSuitCardsList.size() - 4); ++ctr ) {
                int diffOfHighAndLowCards = sameSuitCardsList.get(ctr).getRank().ordinal() - sameSuitCardsList.get(ctr+4).getRank().ordinal();
                if(diffOfHighAndLowCards==4 || diffOfHighAndLowCards == -8) {
                    sameSuitCardsList = sameSuitCardsList.subList(ctr,sameSuitCardsList.size());
                    isStraight = true;
                }
            }

            if(isStraight) {
                return new StraightFlush(sameSuitCardsList);
            } else {
                return new Flush(sameSuitCardsList);
            }
        }



        Map<String,List<Card>> sameCardRankMap = new LinkedHashMap<>();
        for (Card c : combinedCards) {
            if(sameCardRankMap.containsKey(c.getRank().toString())) {
                sameCardRankMap.get(c.getRank().toString()).add(c);
            } else {
                List<Card> tempCardsList = new ArrayList<>();
                tempCardsList.add(c);
                sameCardRankMap.put(c.getRank().toString(),tempCardsList);
            }
        }

        // four of a kind checker
        List<Card> fourOfAKindList = sameCardRankMap.values().stream().filter(l -> l.size()==4).findFirst().orElse(new ArrayList<>());

        if(fourOfAKindList.size()!=0) {
            combinedCards.removeAll(fourOfAKindList);
            return new FourOfAKind(fourOfAKindList, combinedCards);
        }

        // check for straight
        List<Card> straightList = new ArrayList<>();
        int listIndex = 0;
        straightList.add(combinedCards.get(0));

        for(int ctr = 1; ctr < combinedCards.size(); ++ctr) {
            if(straightList.get(listIndex).getRank()!=combinedCards.get(ctr).getRank()) {
                straightList.add(combinedCards.get(ctr));
                ++listIndex;
            }
        }

        if(straightList.get(0).getRank()==CardRank.ACE)
            straightList.add(combinedCards.get(0));

        for(int ctr = 0; ctr < (straightList.size() - 4); ++ctr ) {
            int diff = straightList.get(ctr).getRank().ordinal() - straightList.get(ctr+4).getRank().ordinal();
            if(diff==4 || diff == -8) {

                straightList.subList(ctr,straightList.size());
                return new Straight(straightList);
            }
        }

        // three of a kind checker
        List<Card> threeOfAKindList = sameCardRankMap.values().stream().filter(l -> l.size()==3).findFirst().orElse(new ArrayList<>());

        if(threeOfAKindList.size()!=0) {
            // check for pair kickers, this will be full house
            sameCardRankMap.remove(threeOfAKindList.get(0).getRank().toString());
            List<Card> fullHouseKickerList = sameCardRankMap.values().stream().filter(l -> l.size()>=2).findFirst().orElse(new ArrayList<>());

            if(fullHouseKickerList.size()!=0) {
                return new FullHouse(threeOfAKindList, fullHouseKickerList);
            } else {
                combinedCards.removeAll(threeOfAKindList);
                return new ThreeOfAKind(threeOfAKindList, combinedCards);
            }
        }

        List<Card> twoOfAKindList = sameCardRankMap.values().stream().filter(l -> l.size()==2).findFirst().orElse(new ArrayList<>());

        if(twoOfAKindList.size()!=0) {
            sameCardRankMap.remove(twoOfAKindList.get(0).getRank().toString());
            List<Card> twoOfAKindList2 = sameCardRankMap.values().stream().filter(l -> l.size()==2).findFirst().orElse(new ArrayList<>());

            if(twoOfAKindList2.size()!=0) {
                combinedCards.removeAll(twoOfAKindList);
                combinedCards.removeAll(twoOfAKindList2);
                return new TwoPair(twoOfAKindList,twoOfAKindList2,combinedCards);

            } else {
                combinedCards.removeAll(twoOfAKindList);
                return new OnePair(twoOfAKindList,combinedCards);
            }
        }

        return new HighCard(combinedCards);
    }
}
