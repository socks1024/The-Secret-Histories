package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class InfluenceWinter extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceWinter.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = WINTER;

    public InfluenceWinter() {
        super(ID, PRINCIPLE_TAG);
    }
}
