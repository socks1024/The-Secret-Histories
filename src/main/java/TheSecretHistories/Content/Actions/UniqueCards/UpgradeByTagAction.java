package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.Objects;

public class UpgradeByTagAction extends AbstractGameAction {

    private final AbstractCard.CardTags tag;

    private final AbstractPlayer p = AbstractDungeon.player;

    private ArrayList<AbstractCard> cards = p.hand.group;

    private String notUpgradeCardID;

    public UpgradeByTagAction(AbstractCreature source, AbstractCard.CardTags tags, ArrayList<AbstractCard> cards) {
        this(source, tags);
        this.cards = cards;
    }

    public UpgradeByTagAction(AbstractCreature source, AbstractCard.CardTags tags) {
        this.source = source;
        this.tag = tags;
    }

    public UpgradeByTagAction(AbstractCreature source, AbstractCard.CardTags tags, String notUpgradeCardID) {
        this(source, tags);
        this.notUpgradeCardID = notUpgradeCardID;
    }

    @Override
    public void update() {

        for (AbstractCard c : cards) {

            if (!Objects.equals(c.cardID, notUpgradeCardID)) TryUpgradeThis(c);
        }

        this.isDone = true;
    }

    private void TryUpgradeThis(AbstractCard c){
        if (c.hasTag(tag) && c.canUpgrade()) {
            c.upgrade();
            c.applyPowers();

            if (AbstractDungeon.player.hand.contains(c)) c.superFlash();
        }
    }
}
