package TheSecretHistories.Content.Cards.Spirits;

import TheSecretHistories.Content.Actions.Principle.Summon.SummonAction;
import TheSecretHistories.Content.Cards.Template.TemplateOptionCard;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public abstract class AbstractSummonOption extends TemplateOptionCard {

    private static final CardColor COLOR = CULT_BLUE;

    private final AbstractSpirit spirit;

    public AbstractSummonOption(String id, String imgName, AbstractSpirit spirit) {
        super(id, imgName, COLOR);
        this.spirit = spirit;
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();

        addToBot(new SummonAction(spirit));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {

    }

    public boolean GetAvailable() {
        return spirit.GetAvailable();
    }
}
