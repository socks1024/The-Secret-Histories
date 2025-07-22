package TheSecretHistories.Content.Powers.UniqueCards;

import TheSecretHistories.Content.Powers.Principles.*;
import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class LoseAllAlignmentNextTurnPower  extends TemplateCustomPower {

    public static final String POWER_ID = StringUtils.MakeID(LoseAllAlignmentNextTurnPower.class.getSimpleName());

    private static final String IMG_NAME = "ingredientwinterb";

    public LoseAllAlignmentNextTurnPower(AbstractCreature owner, int amount) {
        super(POWER_ID, IMG_NAME, owner, amount);
        loadRegion("shackle");
    }

    @Override
    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        AbstractPlayer p = AbstractDungeon.player;
        String[] ids = {
                Winter.POWER_ID, Edge.POWER_ID, Grail.POWER_ID,
                Lantern.POWER_ID, Moth.POWER_ID, Heart.POWER_ID,
                Forge.POWER_ID, Knock.POWER_ID, SecretHistories.POWER_ID
        };
        for (String id : ids) {
            this.addToBot(new ReducePowerAction(p, p, id, amount));
        }
        this.addToBot(new RemoveSpecificPowerAction(p, p, this.ID));
    }



}
