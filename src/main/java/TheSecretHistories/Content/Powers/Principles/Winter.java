package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

public class Winter extends AbstractPrinciple{

    public static final String POWER_ID = StringUtils.MakeID(Winter.class.getSimpleName());
    private static final String IMG_NAME = "winter";

    public Winter(AbstractCreature owner, int Amount){
        super(POWER_ID, IMG_NAME);

        this.owner = owner;
        this.amount = Amount;
    }

    @Override
    public void updateDescription(){
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void atEndOfTurnPreEndTurnCards(boolean isPlayer){
        flash();

        if(!this.owner.hasPower("SecretHistories:IngredientWinterBPower")){
            return;
        }

        addToTop(new DamageAction(this.owner,new DamageInfo(this.owner,this.amount)));
    }


}
