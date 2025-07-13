package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayWhite extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayWhite.class.getSimpleName());

    private static final String IMG_NAME = "waywhite";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, WINTER, HEART, KNOCK};
    private static final int LEVEL = 4;

    public WayWhite() {
        super(ID, IMG_NAME, TAGS, LEVEL);
    }
}
