package TheSecretHistories.Content.Powers.Principles;

import TheSecretHistories.Content.Powers.Template.TemplateCustomPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.PRINCIPLE;

public abstract class AbstractPrinciple extends TemplateCustomPower {

    public boolean stack = false;

    public AbstractPrinciple(String id, String img) {
        super(id, img);
        this.type = PRINCIPLE;
    }
}
