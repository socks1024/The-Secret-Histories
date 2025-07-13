package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class InfluenceEdge extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceEdge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = EDGE;

    public InfluenceEdge() {
        super(ID, PRINCIPLE_TAG);
    }
}
