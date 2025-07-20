package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Utils.StringUtils;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;

public class FollowerEdgeRose extends AbstractFollower {
    private static final CardTags PRINCIPLE_TAG = EDGE;

    public static final String ID = StringUtils.MakeID(FollowerEdgeRose.class.getSimpleName());

    private static final String IMG_NAME = "rose";

    private static final int COST = 1;

    private static final CardType TYPE = CardType.SKILL;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;

    private static final CardTarget TARGET = CardTarget.SELF;

    public FollowerEdgeRose() {
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