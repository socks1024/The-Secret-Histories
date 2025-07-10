package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class InfluenceGrail extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceGrail.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = GRAIL;

    public InfluenceGrail() {
        super(ID, PRINCIPLE_TAG);
    }
}
