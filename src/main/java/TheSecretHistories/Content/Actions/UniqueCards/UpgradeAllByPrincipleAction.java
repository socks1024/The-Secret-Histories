package TheSecretHistories.Content.Actions.UniqueCards;

import TheSecretHistories.Utils.DeckUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class UpgradeAllByPrincipleAction extends AbstractGameAction {

    private AbstractCard.CardTags principleTag;

    private final AbstractPlayer p = AbstractDungeon.player;

    public UpgradeAllByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags) {
        this.source = source;
        this.principleTag = tags;
    }

    @Override
    public void update() {

        for (AbstractCard c : DeckUtils.GetBattleDeck()) {
            TryUpgradeThis(c);

            if (p.hand.contains(c)) {
                c.superFlash();
            }
        }

        this.isDone = true;
    }

    private void TryUpgradeThis(AbstractCard c){
        if (c.hasTag(principleTag) && c.canUpgrade()) {
            c.upgrade();
            c.applyPowers();
        }
    }
}
