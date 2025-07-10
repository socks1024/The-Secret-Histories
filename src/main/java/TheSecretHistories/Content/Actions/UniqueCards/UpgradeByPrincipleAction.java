package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class UpgradeByPrincipleAction extends AbstractGameAction {

    private AbstractCard.CardTags principleTag;

    private final AbstractPlayer p = AbstractDungeon.player;

    private boolean multiple = true;

    private CardGroup cardGroup = p.hand;

    private AbstractCard card;

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags, AbstractCard card) {
        this(source, tags);
        this.multiple = false;
        this.card = card;
    }

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags, CardGroup cardGroup) {
        this(source, tags);
        this.cardGroup = cardGroup;
    }

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags) {
        this.source = source;
        this.principleTag = tags;
    }

    @Override
    public void update() {

        if (multiple) {

            for (AbstractCard c : cardGroup.group) {
                boolean b = TryUpgradeThis(c);

                if (b && cardGroup.type == CardGroup.CardGroupType.HAND) c.superFlash();
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
