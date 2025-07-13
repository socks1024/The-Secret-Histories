package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class InfluenceLantern extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceLantern.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = LANTERN;

    public InfluenceLantern() {
        super(ID, PRINCIPLE_TAG);
    }
}
