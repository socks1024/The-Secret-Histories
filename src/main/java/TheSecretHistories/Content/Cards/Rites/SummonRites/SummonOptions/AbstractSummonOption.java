package TheSecretHistories.Content.Cards.Rites.SummonRites.SummonOptions;

import TheSecretHistories.Content.Actions.Principle.Summon.SummonAction;
import TheSecretHistories.Content.Cards.Spirits.AbstractSpirit;
import TheSecretHistories.Content.Cards.Template.TemplateOptionCard;
import TheSecretHistories.Utils.PrincipleUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public abstract class AbstractSummonOption extends TemplateOptionCard {

    private static final CardColor COLOR = CULT_BLUE;

    private final PrincipleUtils.ReducePrincipleInfo[] infos;

    private final AbstractSpirit spirit;

    public AbstractSummonOption(String id, String imgName, PrincipleUtils.ReducePrincipleInfo[] infos, AbstractSpirit spirit) {
        super(id, imgName, COLOR);
        this.infos = infos;
        this.spirit = spirit;
    }

    @Override
    public void onChoseThisOption() {
        super.onChoseThisOption();

        addToBot(new SummonAction(infos, spirit));
    }

    public boolean GetAvailable() {
        return PrincipleUtils.PlayerHasEnoughPrinciple(infos);
    }
}
