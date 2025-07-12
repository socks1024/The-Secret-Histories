package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class UpgradeByPrincipleAction extends AbstractGameAction {

    private final AbstractCard.CardTags principleTag;

    private final AbstractPlayer p = AbstractDungeon.player;

    private boolean multiple = true;

    private ArrayList<AbstractCard> cards = p.hand.group;

    private AbstractCard card;

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags, AbstractCard card) {
        this(source, tags);
        this.multiple = false;
        this.card = card;
    }

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags, ArrayList<AbstractCard> cards) {
        this(source, tags);
        this.cards = cards;
    }

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags) {
        this.source = source;
        this.principleTag = tags;
    }

    @Override
    public void update() {

        if (multiple) {

            for (AbstractCard c : cards) {
                boolean b = TryUpgradeThis(c);

                if (b && AbstractDungeon.player.hand.group.contains(c)) c.superFlash();
            }

        } else {

            TryUpgradeThis(card);

        }

        this.isDone = true;
    }

    private boolean TryUpgradeThis(AbstractCard c){
        if (c.hasTag(principleTag) && c.canUpgrade()) {
            c.upgrade();
            c.applyPowers();
            return true;
        }
        return false;
    }
}
