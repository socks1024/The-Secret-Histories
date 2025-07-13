package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayPeacock extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayPeacock.class.getSimpleName());

    private static final String IMG_NAME = "waypeacock";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, FORGE, EDGE, KNOCK};
    private static final int LEVEL = 10;

    public WayPeacock() {
        super(ID, IMG_NAME, TAGS, LEVEL);
    }
}
