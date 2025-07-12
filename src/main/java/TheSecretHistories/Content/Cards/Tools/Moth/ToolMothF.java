package TheSecretHistories.Content.Cards.Tools.Moth;

import TheSecretHistories.Content.Actions.UniqueCards.DamageByMothAction;
import TheSecretHistories.Content.Cards.Tools.AbstractTool;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;

public class ToolMothF extends AbstractTool {

    public static final String ID = StringUtils.MakeID(ToolMothF.class.getSimpleName());

    private static final CardTags PRINCIPLE_TAG = MOTH;

    private static final String IMG_NAME = "toolmothf";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public ToolMothF() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 0;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(5);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster){
        super.use(abstractPlayer, abstractMonster);

        addToBot(new DamageByMothAction(abstractMonster, abstractPlayer, damage));
    }
}
