package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class InfluenceHeart extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceHeart.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = HEART;

    public InfluenceHeart() {
        super(ID, PRINCIPLE_TAG);
    }
}
