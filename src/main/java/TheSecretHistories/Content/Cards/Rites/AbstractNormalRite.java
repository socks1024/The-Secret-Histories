package TheSecretHistories.Content.Cards.Rites;

import TheSecretHistories.Utils.PrincipleUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public abstract class AbstractNormalRite extends AbstractRite{

    protected final PrincipleUtils.ReducePrincipleInfo[] infos;

    public AbstractNormalRite(String id, String imgName, int cost, CardType type, CardTarget target, PrincipleUtils.ReducePrincipleInfo[] infos) {
        super(id, imgName, cost, type, target);

        this.infos = infos;
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return PrincipleUtils.PlayerHasEnoughPrinciple(infos);
    }
}
