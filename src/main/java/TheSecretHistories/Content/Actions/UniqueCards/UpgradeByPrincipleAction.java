package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.Objects;

public class UpgradeByPrincipleAction extends AbstractGameAction {

    private final AbstractCard.CardTags principleTag;

    private final AbstractPlayer p = AbstractDungeon.player;

    private ArrayList<AbstractCard> cards = p.hand.group;

    private String notUpgradeCardID;

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags, ArrayList<AbstractCard> cards) {
        this(source, tags);
        this.cards = cards;
    }

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags) {
        this.source = source;
        this.principleTag = tags;
    }

    public UpgradeByPrincipleAction(AbstractCreature source, AbstractCard.CardTags tags, String notUpgradeCardID) {
        this(source, tags);
        this.notUpgradeCardID = notUpgradeCardID;
    }

    @Override
    public void update() {

        for (AbstractCard c : cards) {
            boolean b = false;

            if (!Objects.equals(c.cardID, notUpgradeCardID)) b = TryUpgradeThis(c);

            if (b && AbstractDungeon.player.hand.group.contains(c)) c.superFlash();
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
