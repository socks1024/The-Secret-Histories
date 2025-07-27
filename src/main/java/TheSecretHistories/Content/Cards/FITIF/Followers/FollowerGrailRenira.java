package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Actions.Principle.ConsumePrinciple.GrailFAction2;
import TheSecretHistories.Content.Powers.Principles.Grail;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.PowerUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class FollowerGrailRenira extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerGrailRenira.class.getSimpleName());
    private static final String IMG_NAME = "renira_a";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.SKILL;
    public static CardTags PRINCIPLE_TAG = GRAIL;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public FollowerGrailRenira() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.baseMagicNumber = this.magicNumber = 4;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                int Amount = PowerUtils.GetPowerAmount(Grail.POWER_ID, p);
                    int times = Amount / magicNumber;
                    if (times > 0) {
                        for (int i = 0; i < times; i++) {
                            int roll = AbstractDungeon.miscRng.random(2);
                            switch (roll) {
                                case 0:
                                    addToTop(new ApplyPowerAction(m, p, new StrengthPower(m, -1)));
                                    break;
                                case 1:
                                    addToTop(new ApplyPowerAction(m, p, new WeakPower(m, 1, false)));
                                    break;
                                case 2:
                                    addToTop(new ApplyPowerAction(m, p, new VulnerablePower(m, 1, false)));
                                    break;
                            }
                        }
                    }

                this.isDone = true;
            }
        });
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeMagicNumber(-1);
    }
}