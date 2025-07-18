package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.SimpleConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelOptionCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public abstract class AbstractMansusPrinciple extends TemplateMultiLevelOptionCard {

    private static final CardColor COLOR = CULT_BLUE;

    private final CardTags principleTag;

    public AbstractMansusPrinciple(String id, String imgName, CardTags principleTag) {
        super(id, COLOR, 4);

        this.principleTag = principleTag;

        this.principleCount = this.basePrincipleCount = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradePrincipleCount(2);
    }

    @Override
    public void onChoseThisOption() {
        addToTop(new SimpleConsumePrincipleAction(AbstractDungeon.player, principleTag, principleCount));
    }
}
