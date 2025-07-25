package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Powers.UniqueCards.FollowerMothYPower;
import TheSecretHistories.Content.Powers.UniqueCards.ToolMothDPower;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.events.shrines.GremlinMatchGame;

public class Moth extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Moth.class.getSimpleName());
    private static final String IMG_NAME = "moth";

    public Moth(AbstractCreature owner, int amount){
        super(POWER_ID, IMG_NAME, owner, amount);

        this.stack = true;

        if (owner.hasPower(FollowerMothYPower.POWER_ID)) {
            owner.getPower(FollowerMothYPower.POWER_ID).flash();
            addToTop(new DamageAllEnemiesAction(AbstractDungeon.player, PowerUtils.GetPowerAmount(FollowerMothYPower.POWER_ID, owner), DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        }
    }

    @Override
    public void stackPower(int stackAmount) {
        stackAmount += PowerUtils.GetPowerAmount(ToolMothDPower.POWER_ID, owner);

        super.stackPower(stackAmount);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);

        addToTop(new RemoveSpecificPowerAction(owner, owner, POWER_ID));
    }
}
