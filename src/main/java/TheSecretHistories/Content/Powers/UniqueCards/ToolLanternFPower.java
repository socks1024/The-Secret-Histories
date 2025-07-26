package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.PrincipleUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class ToolLanternFPower extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(ToolLanternFPower.class.getSimpleName());

    private static final String IMG_NAME = "toollanternf";

    private static int postFix = 0;

    public ToolLanternFPower(AbstractCreature owner, int amount) {
        super(POWER_ID + postFix, IMG_NAME, owner, amount);
        postFix++;
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();
        addToBot(new DrawCardAction(owner, PrincipleUtils.GetPlayerPrincipleAmount(LANTERN) / amount));
    }
}
