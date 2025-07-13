package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusWay;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class WayWood extends AbstractMansusWay{

    public static final String ID = StringUtils.MakeID(WayWood.class.getSimpleName());

    private static final String IMG_NAME = "waywood";
    private static final CardTags[] TAGS = new CardTags[]{LANTERN, MOTH, KNOCK};
    private static final int LEVEL = 2;

    public WayWood() {
        super(ID, IMG_NAME, TAGS, LEVEL);
    }
}
