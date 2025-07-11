package TheSecretHistories.Content.Cards.Tools.ToolGrail;

import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Content.Powers.UniqueCards.ToolGrailDPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class ToolGrailD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolGrailD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = GRAIL;

    private static final String IMG_NAME = "toolgraild";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;

    public ToolGrailD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBaseCost(1);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        int temp = (AbstractDungeon.getCurrRoom()).monsters.monsters.size();
        for (int i = 0; i < temp; i++) {
            AbstractMonster m = (AbstractDungeon.getCurrRoom()).monsters.monsters.get(i);
            if (!m.isDeadOrEscaped()) {
                addToBot(new ApplyPowerAction(m, abstractPlayer, new ToolGrailDPower(m)));
            }
        }
    }
}
