package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.DeckUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;
import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FRAGMENT;

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

        ((TemplateCustomCard)(cards.get(new Random().nextInt(cards.size())))).DoUpgrade(level);

        isDone = true;
    }
}
