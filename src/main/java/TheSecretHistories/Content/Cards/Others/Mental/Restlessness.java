package TheSecretHistories.Content.Cards.Others.Mental;

import TheSecretHistories.Content.Cards.Others.TemplateCustomStatusCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Restlessness extends TemplateCustomStatusCard {

    public static final String ID = StringUtils.MakeID(Restlessness.class.getSimpleName());

    private static final String IMG_NAME = "restlessness";
    private static final int COST = 1;

    public Restlessness() {
        super(ID, IMG_NAME, COST);

        this.exhaust = true;

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.dontTriggerOnUseCard) addToBot(new MakeTempCardInDiscardAction(new Dread(), magicNumber));
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
        AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(this, true));
    }
}
