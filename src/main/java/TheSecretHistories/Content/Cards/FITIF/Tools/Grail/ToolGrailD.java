package TheSecretHistories.Content.Cards.FITIF.Tools.Grail;

import TheSecretHistories.Content.Cards.FITIF.Tools.AbstractTool;
import TheSecretHistories.Content.Powers.UniqueCards.ToolGrailDPower;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class ToolGrailD extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolGrailD.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = GRAIL;

    private static final String IMG_NAME = "toolgraild";
    private static final int COST = 1;
    private static final CardType TYPE = CardType.POWER;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;

    public ToolGrailD() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isInnate = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        ArrayList<AbstractMonster> temp = (AbstractDungeon.getCurrRoom()).monsters.monsters;
        for (AbstractMonster m : temp) {
            if (!m.isDeadOrEscaped()) {
                addToBot(new ApplyPowerAction(m, abstractPlayer, new ToolGrailDPower(m)));
            }
        }
    }
}
