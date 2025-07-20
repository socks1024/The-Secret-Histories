package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class FollowerForgeLaidlaw extends AbstractFollower{
    public static CardTags PRINCIPLE_TAG = FORGE;

    public static final String ID = StringUtils.MakeID(FollowerForgeLaidlaw.class.getSimpleName());

    private static final String IMG_NAME = "laidlaw";

    private static final int COST = 2;

    private static final CardType TYPE = CardType.SKILL;


    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    public FollowerForgeLaidlaw() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 13;
    }
}
/*private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());

    private static final String IMG_NAME = "elridge";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.ATTACK;

    private static final CardRarity RARITY = CardRarity.COMMON;

    private static final CardTarget TARGET = CardTarget.ENEMY;*/