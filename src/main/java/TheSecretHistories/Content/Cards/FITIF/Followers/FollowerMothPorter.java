package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.IngredientEdgeFPrincipleAction;
import TheSecretHistories.Content.Cards.FITIF.Followers.AbstractFollower;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.PowerUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import TheSecretHistories.Utils.StringUtils;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class FollowerMothPorter extends AbstractFollower {

    public static final String ID = StringUtils.MakeID(FollowerMothPorter.class.getSimpleName());
    private static final String IMG_NAME = "porter_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = MOTH;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public FollowerMothPorter() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseBlock = 6;
        this.magicNumber=4;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                int mothAmount = PowerUtils.GetPowerAmount(Moth.POWER_ID, p);
                int times = mothAmount / magicNumber;
                if (times > 0) {
                    addToBot(new GainBlockAction(p, p, times * baseBlock));
                }
                isDone=true;
            }
        });

    }


    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeMagicNumber(-1);
    }
}
///*private static final CardTags PRINCIPLE_TAG = EDGE;
//
//    public static final String ID = StringUtils.MakeID(FollowerEdgeElridge.class.getSimpleName());
//
//    private static final String IMG_NAME = "elridge";
//
//    private static final int COST = 1;
//
//    private static final CardType TYPE = CardType.ATTACK;
//
//    private static final CardRarity RARITY = CardRarity.COMMON;
//
//    private static final CardTarget TARGET = CardTarget.ENEMY;*/