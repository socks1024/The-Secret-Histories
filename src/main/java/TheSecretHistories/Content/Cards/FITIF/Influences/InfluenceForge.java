package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class InfluenceForge extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceForge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = FORGE;

    public InfluenceForge() {
        super(ID, PRINCIPLE_TAG);
    }
}
