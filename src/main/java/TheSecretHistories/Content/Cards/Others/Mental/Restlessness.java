package TheSecretHistories.Content.Cards.Others.Mental;

import TheSecretHistories.Content.Cards.Others.TemplateCustomStatusCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
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

        this.cardsToPreview = new Dread();
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    @Override
    public void triggerWhenDrawn() {
        addToBot(new ExhaustSpecificCardAction(this, AbstractDungeon.player.hand));
        addToBot(new MakeTempCardInHandAction(new Dread(), magicNumber));
    }
}
