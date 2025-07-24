package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class SpiritWinterMothPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(SpiritWinterMothPower.class.getSimpleName());

    private static final String IMG_NAME = "spirit_winterb_heart";

    public SpiritWinterMothPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
    }

    @Override
    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        addToBot(new GainBlockAction(owner, PrincipleUtils.GetPlayerPrincipleAmount(WINTER) * amount));
        addToBot(new RemoveSpecificPowerAction(owner, owner, Winter.POWER_ID));
    }
}
