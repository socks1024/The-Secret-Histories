package TheSecretHistories.Content.Cards.Starters.Generics;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public abstract class AbstractGenericDefend extends AbstractGeneric{

    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public AbstractGenericDefend(String id, String img, CardTags principleTag) {
        super(id, img, TYPE, TARGET, principleTag);

        this.block = this.baseBlock = 5;

        this.tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeBlock(3);
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        super.use(player, monster);

        addToBot(new GainBlockAction(player, baseBlock));
    }
}
