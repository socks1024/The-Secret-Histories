package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WaySpider extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WaySpider.class.getSimpleName());

    private static final String IMG_NAME = "wayspider";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, GRAIL, KNOCK};
    private static final int LEVEL = 8;

    public WaySpider() {
        super(ID, IMG_NAME, TAGS, LEVEL);
    }
}
