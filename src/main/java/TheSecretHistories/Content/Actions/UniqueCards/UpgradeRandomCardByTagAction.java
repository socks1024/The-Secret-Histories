package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.DeckUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;
import java.util.Random;

public class UpgradeRandomCardByTagAction extends AbstractGameAction {

    private final AbstractCard.CardTags tag;
    private final int level;
    private final AbstractCard card;

    public UpgradeRandomCardByTagAction(AbstractCard.CardTags tag, int level, AbstractCard currCard) {
        this.tag = tag;
        this.level = level;
        this.card = currCard;
    }

    @Override
    public void update() {
        ArrayList<AbstractCard> cards = DeckUtils.GetCardsInBattleDeck(tag);

        if (card.hasTag(tag)) cards.add(card);

        for (int i = cards.size() - 1; i >= 0; i--) {
            if (cards.get(i).upgraded) cards.remove(cards.get(i));
        }

        if (!cards.isEmpty()) ((TemplateCustomCard)(cards.get(new Random().nextInt(cards.size())))).DoUpgrade(level);

        isDone = true;
    }
}
