package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.SimpleConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class MansusFrangiclave extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusFrangiclave.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = KNOCK;

    public MansusFrangiclave(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }

    @Override
    public void onChoseThisOption() {
        // addToTop(new SimpleConsumePrincipleAction(AbstractDungeon.player, principleTag, principleCount));
        way.onConsumedPrinciple(false);
    }
}
