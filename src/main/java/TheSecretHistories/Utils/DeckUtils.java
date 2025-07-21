package TheSecretHistories.Utils;

import TheSecretHistories.Content.Cards.Mansus.Mansus;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.Objects;

public class DeckUtils {

    public static boolean HasMansus() {
        return (GetFirstCardInMasterDeck(Mansus.ID) != null);
    }

    public static int GetMansusLevel() {

        AbstractCard mansusCard = GetFirstCardInMasterDeck(Mansus.ID);

        if (mansusCard != null) {
            return mansusCard.timesUpgraded + 1;
        }

        return 0;
    }

    public static AbstractCard GetMansusCard() {
        for (AbstractCard card : GetBattleDeck()) {
            if (Objects.equals(card.cardID, Mansus.ID)) return card;
        }

        return null;
    }

    public static ArrayList<AbstractCard> GetBattleDeck() {
        ArrayList<AbstractCard> battleDecks = new ArrayList<>();

        battleDecks.addAll(AbstractDungeon.player.hand.group);
        battleDecks.addAll(AbstractDungeon.player.discardPile.group);
        battleDecks.addAll(AbstractDungeon.player.drawPile.group);

        return battleDecks;
    }

    public static ArrayList<AbstractCard> GetCardsInBattleDeck(AbstractCard.CardTags tag) {

        ArrayList<AbstractCard> cards = new ArrayList<>();

        for (AbstractCard card : GetBattleDeck()) {
            if (card.hasTag(tag)) {
                cards.add(card);
            }
        }

        return cards;

    }

    public static AbstractCard GetFirstCardInMasterDeck(String ID) {

        return AbstractDungeon.player.masterDeck.findCardById(ID);

    }

    public static ArrayList<AbstractCard> GetCardsInMasterDeck(String ID) {
        ArrayList<AbstractCard> cards = new ArrayList<>();

        AbstractDungeon.player.masterDeck.group.forEach((card) -> {
            if (Objects.equals(card.cardID, ID)) cards.add(card);
        });

        return cards;
    }
}
