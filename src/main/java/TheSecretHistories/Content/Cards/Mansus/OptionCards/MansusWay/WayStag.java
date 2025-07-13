package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayStag extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayStag.class.getSimpleName());

    private static final String IMG_NAME = "waystag";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, KNOCK};
    private static final int LEVEL = 6;

    public WayStag() {
        super(ID, IMG_NAME, TAGS, LEVEL);
    }
}
