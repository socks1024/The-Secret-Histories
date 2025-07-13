package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class InfluenceMoth extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceMoth.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = MOTH;

    public InfluenceMoth() {
        super(ID, PRINCIPLE_TAG);
    }
}
