package uk.ac.bris.cs.scotlandyard.model;

import com.google.common.collect.ImmutableList;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableSet;
import uk.ac.bris.cs.scotlandyard.model.Board.GameState;
import uk.ac.bris.cs.scotlandyard.model.ScotlandYard.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * cw-model
 * Stage 1: Complete this class
 */
public final class MyGameStateFactory implements Factory<GameState> {

	@Nonnull @Override public GameState build(
			GameSetup setup,
			Player mrX,
			ImmutableList<Player> detectives) {
            return new MyGameState(setup, ImmutableSet.of(Piece.MrX.MRX), ImmutableList.of(), mrX, detectives);

	}
		// TODO
		 private final class MyGameState implements GameState {
		    private GameSetup setup;
		    private ImmutableSet<Piece> remaining;
		    private ImmutableList<LogEntry> log;
		    private Player mrX;
		    private List<Player> detectives;
		    private ImmutableList<Player> everyone;
		    private ImmutableSet<Move> moves;
		    private ImmutableSet<Piece> winner;
			private MyGameState(final GameSetup setup, final ImmutableSet<Piece> remaining,final ImmutableList<LogEntry> log, final Player mrX, final List<Player> detectives){
				 if(setup == null || remaining == null || log == null || mrX == null || detectives ==null) throw new NullPointerException();// check if the arguments passed in are Null.
				 CheckMrX(mrX);
				 CheckMoreThanOneMrX(detectives);
                 CheckDuplicateDetectives(detectives);
                 CheckLocationOverLapBetweenDetectives(detectives);
			     this.setup = setup;
                 this.remaining = remaining;
                 this.log = log;
                 this.mrX = mrX;
			     this.detectives = detectives;
			}
			@Override
			public GameSetup getSetup() {
				return null;
			}
			@Override
			public ImmutableSet<Piece> getPlayers() {
				return null;
			}
			@Override
			public Optional<Integer> getDetectiveLocation(Piece.Detective detective) {
				return null;
			}
			@Override
			public Optional<Board.TicketBoard> getPlayerTickets(Piece piece){return null;}
			@Override
			public ImmutableList<LogEntry> getMrXTravelLog(){return null;}
			@Override
			public ImmutableSet<Piece> getWinner(){return null;};
			@Override
			public ImmutableSet<Move> getAvailableMoves(){return null;}
			@Override
			public GameState advance(Move move) { return null; }
            public void CheckMrX(Player mrX){if(mrX.isDetective()) throw new IllegalArgumentException(); }
            public void CheckMoreThanOneMrX(final List<Player> detectives){
				for (Player player: detectives) {
					if(!player.isDetective()) throw new IllegalArgumentException();
				}
			}
			public void CheckDuplicateDetectives(final List<Player> detectives){
				List<Player> list = new ArrayList<>();
				for (Player player : detectives){
					if(list.contains(player)) throw new IllegalArgumentException();
					if(player != null) list.add(player);
				}

			}
			public void CheckLocationOverLapBetweenDetectives(final List<Player> detectives){
				
			}
		}




	}


