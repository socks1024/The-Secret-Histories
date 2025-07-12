package TheSecretHistories.Utils;

import TheSecretHistories.Content.Cards.Mansus.Mansus;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class DeckUtils {

    public static int GetMansusLevel() {

        AbstractCard mansusCard = GetFirstCardInBattleDeck(Mansus.ID);

        if (mansusCard != null) {
            return mansusCard.timesUpgraded + 1;
        }

        return 0;
    }

    public static ArrayList<AbstractCard> GetBattleDeck() {
        ArrayList<AbstractCard> battleDecks = new ArrayList<>();

        battleDecks.addAll(AbstractDungeon.player.hand.group);
        battleDecks.addAll(AbstractDungeon.player.discardPile.group);
        battleDecks.addAll(AbstractDungeon.player.drawPile.group);

        return battleDecks;
    }

    public static AbstractCard GetFirstCardInBattleDeck(String ID) {

        AbstractCard retCard = AbstractDungeon.player.masterDeck.findCardById(ID);

        return retCard;

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
}
