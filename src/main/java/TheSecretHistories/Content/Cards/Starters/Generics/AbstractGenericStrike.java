package TheSecretHistories.Content.Cards.Starters.Generics;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public abstract class AbstractGenericStrike extends AbstractGeneric{

    private static final CardType TYPE = CardType.ATTACK;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    public AbstractGenericStrike(String id, String img, CardTags principleTag) {
        super(id, img, TYPE, TARGET, principleTag);

        this.damage = this.baseDamage = 6;

        this.tags.add(CardTags.STARTER_STRIKE);
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(3);
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        super.use(player, monster);

        addToBot(new DamageAction(monster, new DamageInfo(player, damage)));
    }
}
