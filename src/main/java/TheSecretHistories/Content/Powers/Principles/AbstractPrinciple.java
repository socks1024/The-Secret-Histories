package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.PRINCIPLE;

public abstract class AbstractPrinciple extends TemplateCustomPower {

    public boolean stack = false;

    public AbstractPrinciple(String id, String img, AbstractCreature owner, int amount) {
        super(id, img, owner, amount);
        this.type = PRINCIPLE;
    }

    @Override
    public void stackPower(int stackAmount) {
        if (stack) super.stackPower(stackAmount);

        if (amount < stackAmount){
            amount = stackAmount;
        }
    }
}
