package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Utils.DeckUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;

import java.util.ArrayList;

public class RetainAllTaggedCardsAction extends AbstractGameAction {

    private AbstractCard.CardTags tag;

    public RetainAllTaggedCardsAction(AbstractCreature source, AbstractCard.CardTags tag) {
        this.source = source;
        this.tag = tag;
    }

    @Override
    public void update() {
        ArrayList<AbstractCard> cards = DeckUtils.GetCardsInBattleDeck(tag);

        for (AbstractCard c : cards) {
            c.retain = true;
        }

        isDone = true;
    }
}
