package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusPrinciple;

import TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay.AbstractMansusWay;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class MansusMoth extends AbstractMansusPrinciple{

    public static final String ID = StringUtils.MakeID(MansusMoth.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = MOTH;

    public MansusMoth(AbstractMansusWay way) {
        super(ID, PRINCIPLE_TAG, way);
    }
}
