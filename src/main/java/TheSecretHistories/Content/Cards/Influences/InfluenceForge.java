package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class InfluenceForge extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceForge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = FORGE;

    public InfluenceForge() {
        super(ID, PRINCIPLE_TAG);
    }
}
