package TheSecretHistories.Content.Cards.Others.Mental;

import TheSecretHistories.Content.Cards.Others.TemplateCustomStatusCard;
import TheSecretHistories.Content.Powers.UniqueCards.DreadPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Dread extends TemplateCustomStatusCard {

    public static final String ID = StringUtils.MakeID(Dread.class.getSimpleName());

    private static final String IMG_NAME = "dread";

    public Dread() {
        super(ID, IMG_NAME);

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    @Override
    public void triggerWhenDrawn() {
        super.onMoveToDiscard();
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DreadPower(AbstractDungeon.player, magicNumber)));
    }
}
