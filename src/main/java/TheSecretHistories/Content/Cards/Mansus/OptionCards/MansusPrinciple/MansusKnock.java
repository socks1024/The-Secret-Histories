package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.SimpleConsumePrincipleAction;
import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class MansusKnock extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusKnock.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = KNOCK;

    public MansusKnock(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }

    @Override
    public void onChoseThisOption() {
        addToTop(new SimpleConsumePrincipleAction(AbstractDungeon.player, principleTag, principleCount));
        way.onConsumedPrinciple(true);
    }
}
