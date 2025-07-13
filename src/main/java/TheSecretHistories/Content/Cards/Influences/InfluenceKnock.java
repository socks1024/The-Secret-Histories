package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class InfluenceKnock extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceKnock.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = KNOCK;

    public InfluenceKnock() {
        super(ID, PRINCIPLE_TAG);
    }
}
